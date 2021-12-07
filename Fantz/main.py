import re


def get_all_powers_of_num(number, str_number):
    return_array = list()
    max_len = len(re.split(r'^0*', str_number)[1])
    square_number = ''
    while len(square_number) <= max_len:
        square_number = bin(number ** len(return_array)).replace('0b', '')
        return_array.append(square_number)
    return return_array[::-1]


def findDivisionNum(number, binary_number_str):
    array_of_pow = get_all_powers_of_num(number, binary_number_str)
    count = 0
    while True:
        found_pow_str = ''
        for pow_of_number in array_of_pow:
            if binary_number_str[0:len(pow_of_number)] == pow_of_number:
                found_pow_str = pow_of_number
                count += 1
                break
        found_pow_str_len = len(found_pow_str)
        if found_pow_str_len:
            binary_number_str = binary_number_str[found_pow_str_len:]
        else:
            if not len(binary_number_str):
                return count
            return -1 

if __name__ == '__main__':
    input_binary_number_str = input("Binary string:")
    number_to_find = input("Number whose power divisions to find: ")
    print(findDivisionNum(int(number_to_find), input_binary_number_str))
