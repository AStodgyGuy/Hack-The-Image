#include <iostream>
#include <string>

#include <AES.hpp>
#include <Image.hpp>

int main() {
	/* std::string filename; */
	/* getline(std::cin, filename); */
	/* Image img(filename); */
	Image img("./screenshot.png");

	std::string msg = img.DecryptMessage();
	AES aes;
	msg = aes.Decrypt(msg, "0123456789012345");
	std::cout << msg << std::endl;
}
