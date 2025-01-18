equation = @(a,b) (1 - a).^2 + (2 - a * exp(b)).^2 + (5-a*exp(2*b)).^2;

answer = fminsearch(@(u) equation(u(1),u(2)) , [1,1])

x = 0:0.1:2;
function1 = x.^2 + 1;
function2 = 0.8838*exp(0.8644*x);

%please note the numbers used were found with the above code
% a = 0.8838, b = 0.8644

plot(x,function1,x,function2)
