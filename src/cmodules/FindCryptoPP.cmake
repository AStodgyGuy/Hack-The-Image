# FindCrypto++ package
#
# Tries to find the Crypto++ library
#

find_package(PkgConfig)

include(LibFindMacros)

# Include dir
find_path(CryptoPP_INCLUDE_DIR
	NAMES
		crypto++/cryptlib.h cryptopp/cryptlib.h
	PATHS
		${CMAKE_CURRENT_SOURCE_DIR}/vendors/cryptopp
		${CryptoPP_PKGCONF_INCLUDE_DIRS}
		${CryptoPP_DIR}
		$ENV{CryptoPP_DIR}
		/usr/local/include
		/usr/include
	PATH_SUFFIXES
		include
		Release/include
)

IF (NOT EXISTS "${CryptoPP_INCLUDE_DIR}/crypto++/cryptlib.h" AND EXISTS "${CryptoPP_INCLUDE_DIR}/cryptopp/cryptlib.h")
		SET(USE_CRYPTO_PP true)
ENDIF()

# Library
find_library(CryptoPP_UTILS_LIBRARY
	NAMES
		cryptopp cryptlib
	PATHS
		${CMAKE_CURRENT_SOURCE_DIR}/vendors/cryptopp/crypto++
		${CMAKE_CURRENT_SOURCE_DIR}/vendors/cryptopp/crypto++/Win32/Output
		${CryptoPP_PKGCONF_LIBRARY_DIRS}
		${CryptoPP_DIR}
		$ENV{CryptoPP_DIR}
		/usr/local
		/usr
	PATH_SUFFIXES
		build
		lib
		Debug
		Release
)

set(CryptoPP_PROCESS_LIBS CryptoPP_LIBRARY CryptoPP_UTILS_LIBRARY)
set(CryptoPP_PROCESS_INCLUDES CryptoPP_INCLUDE_DIR)
libfind_process(CryptoPP)

