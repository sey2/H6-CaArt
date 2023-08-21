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

max_data_len = 1000001

purchase_data = []
selected_option_data = []

for i in range(1, max_data_len):
    # 나이 (20 ~ 79)
    age = random.randrange(20, 80)
    # 모델 (1 ~ 32)
    model_id = random.randrange(1, 33)  
    # 외장 색상 (1 ~ 6)
    exterior_color_id = random.randrange(1, 7)  
    # 내장 색상 (트림별 상이)
    if 1 <= model_id <= 8: 
        # 르블랑
        interior_color_id = random.randrange(7, 9)
        if model_id <= 4:
            options = available_options[0]
        else:
            options = available_options[1]
    elif 9 <= model_id <= 16: 
        # 익스클루시브
        interior_color_id = 9
        if model_id <= 12:
            options = available_options[2]
        else:
            options = available_options[3]
    elif 17 <= model_id <= 24: 
        # 프레스티지
        interior_color_id = random.randrange(10, 13)
        if model_id <= 20:
            options = available_options[4]
        else:
            options = available_options[5]
    else: 
        # 캘리그라피
        interior_color_id = random.randrange(14, 17)
        if model_id <= 28:
            options = available_options[6]
        else:
            options = available_options[7]
    # 추가 옵션
    option_id = random.choice(options)
    # 데이터(레코드) 추가
    purchase_data.append([i, age, model_id, exterior_color_id, interior_color_id]) # PK, 나이, 모델 아이디, 외장 색상 아이디, 내장 색상 아이디
    selected_option_data.append([i, random.randrange(1, max_data_len), option_id]) # PK, FK(purchase_data 인덱스), 옵션 아이디


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
