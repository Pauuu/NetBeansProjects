/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: pau
 *
 * Created on 10 de abril de 2018, 0:27
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main() {
    printf("hola q tal");
    int a, b, r;

    printf("Esto es una caluladora, de momento solo hace sumas \n");

    scanf("%d\n", &a);
    scanf("%d\n", &b);

    r = a + b;

    printf("%d", r);

    return 0;
}

