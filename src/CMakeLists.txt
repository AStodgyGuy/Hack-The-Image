cmake_minimum_required(VERSION 2.8.2)

project(hack-the-image)

set(HACK_ROOT ${CMAKE_CURRENT_SOURCE_DIR})
set(HACK_LIB ${HACK_ROOT}/lib)
set(HACK_INCLUDE ${HACK_ROOT}/include)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${HACK_ROOT}/bin)
set(CMAKE_MODULE_PATH ${HACK_ROOT}/cmodules)

add_subdirectory(./lib)
