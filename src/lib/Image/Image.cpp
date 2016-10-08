#include "Image.hpp"

#include <cstdio>
#include <cstdlib>

#define CHAR_S (sizeof(unsigned char) * 8)

Image::Image(const std::string filename):
	filename_(filename), cimage(filename.c_str())
{}

Image::~Image() {
}

Image::vec4 Image::operator[] (const size_t idx) {
	return cimage[idx % cimage.height()];
}


void Image::EncryptMessage(std::string msg) {
	msg += TERMINATOR;

	if(cimage.width() * cimage.height() < msg.length() * CHAR_S)
		throw new std::runtime_error("error: message length exceeds number of pixels.");

	for(size_t i = 0; i < msg.length(); ++i) {
		for(size_t x = 0; x < CHAR_S; ++x) {
			const bool info = ((msg[i] & (1 << x)) != 0);
			vec4 &px = cimage[i * CHAR_S + x];
			px = (px & (~1)) ^ info;
		}
	}
}

std::string Image::DecryptMessage() {
	size_t size = (cimage.width() * cimage.height()) / CHAR_S;
	char *data = (char *)malloc(size + 1);
	memset(data, 0x00, size);
	for(size_t i = 0; i < size; ++i) {
		for(int x = 0; x < CHAR_S; ++x) {
			char &c = data[i];
			c |= (cimage[i * CHAR_S + x] & 1) << x;
		}
	}
	data[size] = 0x00;
	for(size_t i = 0; i < size - TERMINATOR.length(); ++i) {
		if(!strcmp(TERMINATOR.c_str(), &data[i])) {
			size = i;
			break;
		}
	}
	std::string msg;
	msg.reserve(size);
	for(size_t i = 0; i < size; ++i)
		msg[i] = data[i];
	free(data);
	return msg;
}


void Image::Save(const std::string &new_filename) {
	cimage.save(new_filename.c_str());
}

void Image::Print() {
	for(int i = 0; i < cimage.height(); ++i) {
		for(int j = 0; j < cimage.width(); ++j) {
			printf("%X ", cimage[i * cimage.width() + j]);
		}
		printf("\n");
	}
}
