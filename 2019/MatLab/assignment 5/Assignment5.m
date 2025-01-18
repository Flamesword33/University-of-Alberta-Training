% x1 = zeros(1, 301);
% x2 = zeros(1, 301);
% a = 0
% 
% for i = 1:17
%     J = [2*exp(2*x1(i)-x2(i))-1 -exp(2*x1(i)-x2(i)) ; 2*x1(i) -1];
%     
%     A = [exp(2*x1(i)-x2(i))-x1(i) ; x1(i)^2-x2(i)];
%     
%     %equivilent to inv(J) * A
%     J2 = J\A;
%     
%     x1(i + 1) = x1(i) - J2(1);
%     x2(i + 1) = x2(i) - J2(2);
%     a = i + 1;
% end
% 
% x1(a)
% x2(a)
% 
% A(1)^2 + A(2)^2

x1 = zeros(1, 301);
x2 = zeros(1, 301);
a = 0;

x1(1) = 0.85;
x2(1) = 0.05;

for i = 1:100
    f = -log(1 - x1(i) - x2(i)) - log(x1(i)) - log(x2(i));
    fx1 = 1/(1-x1(i) - x2(i)) - 1/x1(i);
    fx2 = 1/(1-x1(i) - x2(i)) - 1/x2(i);
    
    x1(i + 1) = x1(i) - (f/fx1);
    x2(i + 1) = x2(i) - (f/fx2);
    x1(i + 1)
    x2(i + 1)
end

% x1(a)
% x2(a)
% 
final_answer = f^2