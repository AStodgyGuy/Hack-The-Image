#ifndef IMAGE_HPP_OK3MC4DQ
#define IMAGE_HPP_OK3MC4DQ

#include <cstdint>
#include <string>


typedef int32_t vec4;

class Image {
protected:
	const std::string filename_;
	void *data_ = NULL;
public:
	Image(const std::string filename);
	virtual ~Image ();
	virtual void load() = 0;
	bool is_loaded();
};


class BMPImage : public Image {
public:
	void load();
};


#endif
