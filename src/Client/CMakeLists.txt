cmake_minimum_required(VERSION 2.8.2)

include_directories(
	${IMGFACE_LIB} ${GIACRYPT_LIB}
)

project(encryptor)

file(
	GLOB ENC_SRCS
	encryptor.cpp
)

add_executable(encryptor ${ENC_SRCS})
target_link_libraries(encryptor giacrypt imgface)
