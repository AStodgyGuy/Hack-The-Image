cmake_minimum_required(VERSION 2.8.2)

find_package(GMP REQUIRED)


file(GLOB
	GIACRYPT_SRC
	*.cpp
)

add_library(giacrypt STATIC ${GIACRYPT_SRC})
include_directories(. ${HACK_INCLUDE} ${GMP_INCLUDE_DIR})

target_link_libraries(giacrypt ${GMPXX_LIBRARIES})

