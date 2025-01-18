h1 = 10^-1;
h2 = 10^-2;
h3 = 10^-3;
h4 = 10^-4;
h5 = 10^-5;
h6 = 10^-6;
h7 = 10^-7;
h8 = 10^-8;
h9 = 10^-9;
h10 = 10^-10;
h11 = 10^-11;
h12 = 10^-12;

a1 = error_using_forward(h1)
a2 = error_using_forward(h2)
a3 = error_using_forward(h3)
a4 = error_using_forward(h4)
a5 = error_using_forward(h5)
a6 = error_using_forward(h6)
a7 = error_using_forward(h7)
a8 = error_using_forward(h8)
a9 = error_using_forward(h9)
a10 = error_using_forward(h10)
a11 = error_using_forward(h11)
a12 = error_using_forward(h12)

b1 = error_using_central(h1)
b2 = error_using_central(h2)
b3 = error_using_central(h3)
b4 = error_using_central(h4)
b5 = error_using_central(h5)
b6 = error_using_central(h6)
b7 = error_using_central(h7)
b8 = error_using_central(h8)
b9 = error_using_central(h9)
b10 = error_using_central(h10)
b11 = error_using_central(h11)
b12 = error_using_central(h12)

function error = error_using_forward(h)
x = 2;
exact_derivative = exp(x);
forward_computed = (exp(x + h) - exp(x))/h;
error = log10((forward_computed - exact_derivative)/exact_derivative);
end

function error = error_using_central(h)
x = 2;
exact_derivative = exp(x);
central_computed = (exp(x + h) - exp(x - h))/(2 * h);
error = log10((central_computed - exact_derivative)/exact_derivative);
end