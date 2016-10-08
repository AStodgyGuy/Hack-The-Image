#include <iostream>
#include <string>

#include <Image.hpp>
#include <AES.hpp>

int main() {
	std::string ip;
	getline(line);
	std::cout << line << std::endl;
	std::string filename;
	getline(filename);
	Image new_image(filename);
	std::string msg;
	getline(msg);

	AES aes;
	msg = aes.Encrypt(msg, "0123456789012345");
	new_image.EncryptMessage(msg);

	std::string output = filename + ".out";
	new_image.Save(output);
	std::cout << output << std::endl;
}
