cmake_minimum_required(VERSION 2.8.2)

find_package(CIMG REQUIRED)


file(GLOB
	IMAGE_SRC
	*.cpp
)

add_library(imgface STATIC ${IMAGE_SRC})
include_directories(. ${CIMG_INCLUDE_DIRS})
target_link_libraries(imgface ${CIMG_LIBRARIES})
