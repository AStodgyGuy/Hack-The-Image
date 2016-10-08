#pragma once

#include <CImg.h>

#include <functional>
#include <cstdint>
#include <string>

using namespace cimg_library;

class Image {
protected:
	const std::string TERMINATOR = "allyourbasearebelongtome";
	typedef bool bit_t;
	typedef int32_t vec4;
	CImg <vec4> cimage;
	const std::string filename_;
public:
	Image(const std::string filename);
	~Image();
	vec4 operator[] (const size_t idx);

	void EncryptMessage(std::string msg);
	std::string DecryptMessage();

	void Save(const std::string &new_filename);
	void Print();
};
