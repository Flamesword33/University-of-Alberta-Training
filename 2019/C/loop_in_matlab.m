% some examples

a = 1.0; %semi colon stops screen output
h = 0.1;
n = 10;
s = 0;

%for i = 1: 0.1: (n-1) %this is if you want to change what interval is used
for i = 1 : (n-1) %this language counts in ints 
    s = s + sin(a+i*h);
end
s


% while 
s = 0;
i = 1;
while i <= (n-1)
    s = s + sin(a+i*h);
    i = i + 1;
end
s

playing_with_loops(n);

% lin algebra stuff
A = [[1 2]; [3 4]];
b = [1 2];
x = A/b  % ' means transpose

x = 0:0.001:2.0;
plot(x, sin(x));

v = 0:0.2:1.0;
w = v * v' %dot product
%Z = cross(v,v) %should be cross product

function output = playing_with_loops(number_of_loops)
a = 1.0;
h = 0.1;
ouput = 0;
i = 1;

while i <= (number_of_loops-1)
    ouput = ouput + sin(a+i*h);
    i = i + 1;
end
ouput
end


