#include "DiffieHellman.hpp"

#include <gmpxx.h>

DiffieHellman::DiffieHellman(int base, int modulus) :   g(base), p(modulus) {}

int DiffieHellman::mod_exp(int base, int exponent, int mod)
{
    mpz_class a = 1;
    for (int i = 0; i < exponent; i++)
    {
        a *= base;
    }
    a %= mod;

    return a.get_si();
}


int DiffieHellman::getIntermediateKey(int a)
{
    priv = a;
    return mod_exp(g, a, p);
}

int DiffieHellman::getFinalKey(int B)
{
    return mod_exp(B, priv, p);
}
