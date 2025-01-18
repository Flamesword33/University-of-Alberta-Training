h(1) = 1;
h(2) = 0.5;
h(3) = 0.25;
h(4) = 0.125;
h(5) = 0.1;
h(6) = 0.0625;
h(7) = 0.05;
h(8) = 0.025;
h(9) = 0.0125;
h(10) = 0.01;
% h(4) = 0.001;
% h(5) = 0.0001;
% h(6) = 0.00001;
% h(7) = 0.000001;
% h(8) = 0.0000001;
% h(9) = 0.00000001;
% h(10) = 0.000000001;

assignment5_question3(h)


function answer = assignment5_question3(h)
y = 0.1;
answer = zeros(2,1);

    
t = 0;
k1 = h(1) * (t*y^2 - cos(t) + 1.1);
k2 = h(1) * ((t+h(1)/2)*(y + k1/2)^2 - cos(t+h(1)/2)+ 1.1);
k3 = h(1) * ((t+h(1)/2)*(y + k2/2)^2 - cos(t+h(1)/2)+ 1.1);
k4 = h(1) * ((t+h(1))*(y + k3)^2 - cos(t+h(1))+ 1.1);
y = y + (k1 + 2*k2 + 2*k3 + k4)/6;

t = t + h(1);
k1 = h(1) * (t*y^2 - cos(t) + 1.1);
k2 = h(1) * ((t+h(1)/2)*(y + k1/2)^2 - cos(t+h(1)/2)+ 1.1);
k3 = h(1) * ((t+h(1)/2)*(y + k2/2)^2 - cos(t+h(1)/2)+ 1.1);
k4 = h(1) * ((t+h(1))*(y + k3)^2 - cos(t+h(1))+ 1.1);
y = y + (k1 + 2*k2 + 2*k3 + k4)/6;

answer1 = y
    
for i = 1:10
    t = 0;
    y = 0.1;
    
    while t < 2 
        k1 = h(i) * (t*y^2 - cos(t) + 1.1);
        k2 = h(i) * ((t+h(i)/2)*(y + k1/2)^2 - cos(t+h(i)/2)+ 1.1);
        k3 = h(i) * ((t+h(i)/2)*(y + k2/2)^2 - cos(t+h(i)/2)+ 1.1);
        k4 = h(i) * ((t+h(i))*(y + k3)^2 - cos(t+h(i))+ 1.1);
        y = y + (k1 + 2*k2 + 2*k3 + k4)/6;
        
        t = t + h(i);
        
    end %while
    answer(i) = y;
end %for 

% answer(1) - answer(2)
% answer(2) - answer(3)
% answer(3) - answer(4)
% answer(4) - answer(5)
% answer(5) - answer(6)
% answer(6) - answer(7)
% answer(7) - answer(8)
% answer(8) - answer(9)
% answer(9) - answer(10)

end %assignment5_question3