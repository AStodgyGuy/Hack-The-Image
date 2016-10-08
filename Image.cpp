#include <cassert>
#include <cstdlib>
#include <cstdio>

#include "Image.hpp"

Image::Image(const std::string filename):
	filename_(filename)
{}

Image::~Image() {
	if(is_loaded())
		free(data_);
}


bool Image::is_loaded() {
	return data_ == NULL;
}


void BMPImage::load() {
	const int SZ_HEADER = 54;

	FILE *bmp = fopen(filename_.c_str(), "rb");
	assert(bmp != NULL);

	void *header = alloca(SZ_HEADER);
	assert(header != NULL);
	int bytes_read = fread(header, 1, SZ_HEADER, bmp);
	assert(bytes_read == SZ_HEADER);
}
