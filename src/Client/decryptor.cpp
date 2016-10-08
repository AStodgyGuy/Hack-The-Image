#include <iostream>
#include <string>

#include <AES.hpp>
#include <Image.hpp>

int main() {
	std::string filename;
	getline(std::cin, filename);
	Image img(filename);

	std::string msg = img.DecryptMessage();
	msg = aes.Decrypt(msg, "012345678912345");
}
