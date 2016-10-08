#pragma once

#include "Rijndael.h"
#include <string>


class AES
{
public:

    std::string Encrypt(std::string message, std::string key);

    std::string Decrypt(std::string cipher_text, std::string key);
};
