cmake_minimum_required(VERSION 2.8.2)

include_directories(
	${IMGFACE_LIB} ${GIACRYPT_LIB}
)

project(cryptors)

file(
	GLOB ENC_SRCS
	encryptor.cpp
)

file(
	GLOB DEC_SRCS
	decryptor.cpp
)

add_executable(encryptor ${ENC_SRCS})
add_executable(decryptor ${ENC_SRCS})
target_link_libraries(encryptor giacrypt imgface)
target_link_libraries(decryptor giacrypt imgface)

find_package(Java)
include(UseJava)

file(
	GLOB UIFACE_SRCS
	userInterface.java
)

add_jar(${UIFACE_SRCS})
