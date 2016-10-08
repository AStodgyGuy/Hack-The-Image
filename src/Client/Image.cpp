#include "Image.hpp"

#include <cstdio>
#include <cstdlib>

Image::Image(const std::string filename):
	filename_(filename)
{}

Image::~Image() {
	if(IsLoaded())
		free(data_);
}


bool Image::IsLoaded() {
	return data_ == NULL;
}
