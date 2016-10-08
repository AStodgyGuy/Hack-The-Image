#include "Image.hpp"

#include <cassert>
#include <cstdlib>

void BMPImage::Load() {
	const int SZ_HEADER = 54;

	FILE *bmp = fopen(filename_.c_str(), "rb");
	assert(bmp != NULL);

	char *header = (char *)alloca(SZ_HEADER);
	assert(header != NULL);
	int bytes_read = fread(header, 1, SZ_HEADER, bmp);
	assert(bytes_read == SZ_HEADER);

	auto file_size = *reinterpret_cast<uint32_t *>(&header[2]);
	auto data_offset = *reinterpret_cast<uint32_t *>(&header[10]);
	auto width = *reinterpret_cast<uint32_t *>(&header[18]);
	auto height = *reinterpret_cast<uint32_t *>(&header[22]);
	auto depth = *reinterpret_cast<uint16_t *>(&header[28]);
}
