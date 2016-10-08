cmake_minimum_required(VERSION 2.8.2)

find_package(GMP REQUIRED)

file(GLOB
	CRYPT_SRC
	*.cpp
)

add_library(giacrypt STATIC ${CRYPT_SRC})
include_directories(. ${GOBJECT_INCLUDE_DIR})

target_link_libraries(giacrypt ${GOBJECT_LIBRARIES})
