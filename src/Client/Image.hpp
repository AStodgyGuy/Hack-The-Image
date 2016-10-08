#pragma once

#include <cstdint>
#include <string>


typedef struct _col_t {
	char r, g, b, a;
} col_t;


class Image {
protected:
	const std::string filename_;
	void *data_ = NULL;
public:
	Image(const std::string filename);
	virtual ~Image ();
	virtual void Load() = 0;
	bool IsLoaded();
};


class BMPImage : public Image {
public:
	void Load();
};
