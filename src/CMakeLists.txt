cmake_minimum_required(VERSION 2.8.2)

include_directories(
	${IMGFACE_LIB} ${GIACRYPT_LIB}
)

project(cryptors)

add_executable(encryptor encryptor.cpp)
add_executable(decryptor decryptor.cpp)
add_executable(server Server.cpp)
target_link_libraries(encryptor giacrypt imgface)
target_link_libraries(decryptor giacrypt imgface)
