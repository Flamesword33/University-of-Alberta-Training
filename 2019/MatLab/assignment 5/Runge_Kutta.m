
runge_kutta(0,2,0.1,100000) 



function answer = runge_kutta(start_point, end_point, initial_value ...
    , number_of_steps)

t = start_point;
h = end_point/number_of_steps;
w = initial_value;
n = number_of_steps;

for i = 1:n
    k1 = h*f(t,w);
    k2 = h*f(t+h/2, w+k1/2);
    k3 = h*f(t+h/2, w+k2/2);
    k4 = h*f(t+h, w+k3);
    w = w + (k1+2*k2+2*k3+k4)/6;
    t = t + h;
end %for

answer = w;

end %Runge_Kutta

function answer = f(t, y)

answer = y^2 + sin(t);

end