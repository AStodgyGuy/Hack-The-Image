#include <iostream>
#include <string>

#include <Image.hpp>
#include <AES.hpp>

#define CLIENT1PORT 10000
#define CLIENT2PORT 10001

int main() {
	std::string ip;
	std::getline(std::cin, ip);
	std::string filename;
	std::getline(std::cin, filename);
	Image new_image(filename);
	std::string msg;
	std::getline(std::cin, msg);

	AES aes;
	msg = aes.Encrypt(msg, "0123456789012345");
	new_image.EncryptMessage(msg);

	/* std::string output = filename + ".out"; */
	std::string output = "screenshot.png";
	new_image.Save(output);

	std::cout << output << std::endl;
}
