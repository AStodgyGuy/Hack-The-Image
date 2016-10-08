#pragma once

#include <CImg.h>

#include <cstdint>
#include <string>

using namespace cimg_library;

class Image {
protected:
	CImg <unsigned char> cimage;
	const std::string filename_;
public:
	Image(const std::string filename);
	~Image();

	void Print();
};
