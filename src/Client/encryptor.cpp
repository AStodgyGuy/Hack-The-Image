#include <iostream>

#include <Image.hpp>
#include <AES.hpp>

int main() {
	const std::string
		msg = "killmewithyourowntoes";
	const std::string
		input = "./input.png",
		output = "./output.png";
	Image img(input);
	img.EncryptMessage(msg);
	const std::string decr = img.DecryptMessage();
	std::cout << decr.length() << std::endl;
	std::cout << decr << std::endl;
	img.Save(output);
}
