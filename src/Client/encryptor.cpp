#include <iostream>
#include <string>

#include <Image.hpp>
#include <AES.hpp>

int main() {
	/* std::string ip; */
	/* std::getline(std::cin, ip); */

	std::string filename;
	filename = "./image.png";

	/* std::getline(std::cin, filename); */

	Image new_image(filename);
	std::string msg;
	msg = "Hello World";

	/* std::getline(std::cin, msg); */

	AES aes;
	msg = aes.Encrypt(msg, "0123456789012345");
	new_image.EncryptMessage(msg);

	/* std::string output = filename + ".out"; */
	std::string output = "./screenshot.png";
	new_image.Save(output);

	std::cout << output << std::endl;
}
