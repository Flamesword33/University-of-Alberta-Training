taylor_series_exp(5.5)
taylor_series_sin(pi/6 +1000*pi) %the problem is the bigger the number 
%the more error but with small numbers there is no problem

function answer = taylor_series_exp(x)
answer = 0;
n = 0;
term = 1;

while abs(term) > 1.0e-16
   answer = answer + term;
   n = n + 1;
   term = term * x/n;

end
end

function sum = taylor_series_sin(x)
sum = 0;
n = 1;
z = abs(x);
if(z > 2*pi)
    x = mod(x, 2*pi);   %need to find a better way to remove the excess
end

term = x;


while abs(term) > 1.0e-16
    sum = sum + term;
    n = n + 1;
    term = term * x/n;
    n = n + 1;
    term = term * x/n;
    
    sum = sum - term;
    n = n + 1;
    term = term * x/n;
    n = n + 1;
    term = term * x/n;
   
end
end

