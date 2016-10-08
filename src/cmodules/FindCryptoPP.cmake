# - Find Crypto++

if(CRYPTOPP_INCLUDE_DIR AND CRYPTOPPPYrORARIES)
	set(CRYPTOPP_FOUND TRUE)

else(CRYPTOPP_INCLUDE_DIR AND CRYPTOPP_LIBRARIES)
	find_path(CRYPTOPP_INCLUDE_DIR
		NAMES
			cryptlib.h
		PATHS
			/usr/include/crypto++
		/usr/include/cryptopp
		/usr/local/include/crypto++
		/usr/local/include/cryptopp
		/opt/local/include/crypto++
		/opt/local/include/cryptopp
		$ENV{SystemDrive}/Crypto++/include
	)


find_library(CRYPTOPP_LIBRARIES
		NAMES
			libcryptopp.a
			cryptopp
			cryptlib
		PATHS
				/usr/lib
				/usr/local/lib
				/opt/local/lib
				$ENV{SystemDrive}/Crypto++/lib
				${CRYPTOPP_LIBRARIES_DIR}
	)


if(CRYPTOPP_INCLUDE_DIR AND CRYPTOPP_LIBRARIES)
	set(CRYPTOPP_FOUND TRUE)
	message(STATUS "Found Crypto++: ${CRYPTOPP_INCLUDE_DIR}, ${CRYPTOPP_LIBRARIES}")
else(CRYPTOPP_INCLUDE_DIR AND CRYPTOPP_LIBRARIES)
	message(STATUS "Found: ${CRYPTOPP_INCLUDE_DIR}")
	set(CRYPTOPP_FOUND FALSE)
		message(STATUS "Crypto++ not found.")
	endif(CRYPTOPP_INCLUDE_DIR AND CRYPTOPP_LIBRARIES)

	mark_as_advanced(CRYPTOPP_INCLUDE_DIR CRYPTOPP_LIBRARIES)

endif(CRYPTOPP_INCLUDE_DIR AND CRYPTOPP_LIBRARIES)
