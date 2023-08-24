import random
import csv

available_options = [
   [4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17],  # 모델 1~4
   [4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17],    # 5~8
   [1, 2, 3, 6, 7, 8, 10, 11, 12, 14, 15], # 9~12
   [1, 2, 3, 6, 7, 8, 11, 12, 14, 15], # 13~16
   [4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22], # 17~20
   [4, 5, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22], # 21~24
   [7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22], # 25~28
   [7, 8, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22], # 29~32
]

# 2, 4, 8, 9
adoption_rate = {
    1: 0.58,
    2: 0.62,
    3: 0.51,
    4: 0.66,
    5: 0.55,
    6: 0.5,
    7: 0.4,
    8: 0.61,
    9: 0.72,
    10: 0.37,
    11: 0.2,
    12: 0.09,
    13: 0.08,
    14: 0.37,
    15: 0.2,
    16: 0.08,
    17: 0.05,
    18: 0.07,
    19: 0.03,
    20: 0.32,
    21: 0.05,
    22: 0.13
}

max_data_len = 500001
max_option_len = 6

purchase_data = []
selected_option_data = []
selected_option_data_idx = 0


for i in range(1, max_data_len):
    # 나이 (20 ~ 79)
    age = random.randrange(20, 80)
    # 모델 (1 ~ 32)
    model_id = random.randrange(1, 33)  

    # 내장 색상 (트림별 상이)
    if 1 <= model_id <= 8: 
        # 르블랑
        interior_color_id = random.choices(range(7, 9), weights=[0.6, 0.4])[0]

        # 외장 색상 (1 ~ 6) (연령대별 가중치 상이)
        if age < 41:
            exterior_color_id = random.choices(range(1, 7), weights=[0.39, 0.01, 0.03, 0.01, 0.01, 0.55])[0]
        elif age < 51:
            exterior_color_id = random.choices(range(1, 7), weights=[0.29, 0.01, 0.03, 0.01, 0.07, 0.59])[0]
        else:
            exterior_color_id = random.choices(range(1, 7), weights=[0.2, 0.02, 0.06, 0.02, 0.1, 0.6])[0]

    elif 9 <= model_id <= 16: 
        # 익스클루시브
        interior_color_id = 9
        
        # 외장 색상 (1 ~ 6) (연령대별 가중치 상이)
        if age < 41:
            exterior_color_id = random.choices(range(1, 7), weights=[0.02, 0.02, 0.02, 0.02, 0.02, 0.9])[0]
        elif age < 51:
            exterior_color_id = random.choices(range(1, 7), weights=[0.01, 0.01, 0.02, 0.01, 0.2, 0.75])[0]
        else:
            exterior_color_id = random.choices(range(1, 7), weights=[0.28, 0.02, 0.02, 0.01, 0.1, 0.57])[0]

    elif 17 <= model_id <= 24: 
        # 프레스티지
        interior_color_id = random.choices(range(10, 13), weights=[0.3, 0.55, 0.15])[0]

        if age < 41:
            exterior_color_id = random.choices(range(1, 7), weights=[0.6, 0.02, 0.02, 0.01, 0.02, 0.33])[0]
        elif age < 51:
            exterior_color_id = random.choices(range(1, 7), weights=[0.15, 0.03, 0.03, 0.04, 0.15, 0.6])[0]
        else:
            exterior_color_id = random.choices(range(1, 7), weights=[0.2, 0.03, 0.12, 0.03, 0.12, 0.5])[0]
            
    else: 
        # 캘리그라피
        interior_color_id = random.choices(range(14, 17), weights=[0.65, 0.3, 0.05])[0]

        if age < 41:
            exterior_color_id = random.choices([1, 2, 3, 4, 5, 6, 13], weights=[0.31, 0.02, 0.02, 0.04, 0.02, 0.54, 0.05])[0]
        elif age < 51:
            exterior_color_id = random.choices([1, 2, 3, 4, 5, 6, 13], weights=[0.21, 0.01, 0.01, 0.02, 0.01, 0.67, 0.07])[0]
        else:
            exterior_color_id = random.choices([1, 2, 3, 4, 5, 6, 13], weights=[0.18, 0.01, 0.01, 0.06, 0.05, 0.61, 0.08])[0]

    # 추가 옵션
    available_options_id = (model_id - 1) // 4
    option_id_list = []
    for option in available_options[available_options_id]:
        rate = adoption_rate[option]
        selected = random.choices(population=[option, None], weights=[rate, 1 - rate])[0]
        if selected:
            option_id_list.append(selected)

    # 데이터(레코드) 추가
    purchase_data.append([i, age, model_id, exterior_color_id, interior_color_id]) # PK, 나이, 모델 아이디, 외장 색상 아이디, 내장 색상 아이디
    for option_id in option_id_list:
        selected_option_data_idx += 1
        selected_option_data.append([selected_option_data_idx, i, option_id]) # PK, FK(purchase_data 인덱스), 옵션 아이디


# 구매 데이터 csv로 출력
csv_filename = 'purchase_data.csv'
with open(csv_filename, 'w', newline='') as csv_file:
    csv_writer = csv.writer(csv_file)
    csv_writer.writerow(['purchase_id', 'age', 'model_id', 'exterior_color_id', 'interior_color_id'])
    csv_writer.writerows(purchase_data)


# 구매한 옵션 데이터 csv로 출력
csv_filename = 'selected_option_data.csv'
with open(csv_filename, 'w', newline='') as csv_file:
    csv_writer = csv.writer(csv_file)
    csv_writer.writerow(['rel_purchase_additional_option_info_id', 'purchase_id', 'additional_option_info_id'])
    csv_writer.writerows(selected_option_data)
