cmake_minimum_required(version 2.8.2)

project(hack-the-image)

set(HACK_ROOT ${CMAKE_CURRENT_SOURCE_DIR})
set(HACK_LIB ${HACK_ROOT}/lib)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${PROJECT_BIN})

add_subdirectory(./lib)
