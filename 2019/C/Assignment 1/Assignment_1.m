% Assignment_1.m
% AUCSC 340
% by Nathan Pelletier
% started January 31 2019
% finished January 31 2019 

convert_base_ten_to_binary(123)
convert_base_ten_to_ternary(123)
converging_series()

function binary_number = convert_base_ten_to_binary(base_ten_number)
counter = 1;
binary_number = 0;
while base_ten_number > 0 && counter < 100000000

    temp = base_ten_number;
    base_ten_number = bitshift(base_ten_number, -1);
    
    if temp ~= bitshift(base_ten_number, 1)
        binary_number = binary_number + counter;
    end
    
    counter = counter * 10;
end

end

function ternary_number = convert_base_ten_to_ternary(base_ten_number)
ternary_number = 0;
counter1 = 1;
counter2 = 2;
base = 3;
while base_ten_number > 0 && counter1 < 100000000
    
    if mod(base_ten_number, base) == 1
        ternary_number = ternary_number + counter1;
    end
    
    if mod(base_ten_number, base) == 2
        ternary_number = ternary_number + counter2;
    end
    
    base_ten_number = base_ten_number / base; %/ adds the remainder yuck
    base_ten_number = floor(base_ten_number);
    counter1 = counter1 * 10;
    counter2 = counter2 * 10;
    
end
end



function x = converging_series()
i = 0;
result = 0.0;
result = 1/(4 + result);
while i < 8
    i = i + 1;
    result = 1/(4 + result);
end
result = result *10;
x = result + "e -1";
end



































