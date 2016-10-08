#include <DiffieHellman.h>

#include <gmpxx.h>

DiffieHellman::DiffieHellman(int base, int modulus) :   g(base), p(modulus) {}

int ModExp(int base, int exponent, int mod)
{
    mpz_class a = 1;
    for (int i = 0; i < exponent)
    {
        a *= base;
    }
    return (a % mod).get_ui();
}


DiffieHellman::getIntermediateKey(int a)
{
    priv = a;
    return ModExp(g, a, p);
}

DiffieHellman::getFinalKey(int B)
{
    return ModExp(B, priv, p);
}
