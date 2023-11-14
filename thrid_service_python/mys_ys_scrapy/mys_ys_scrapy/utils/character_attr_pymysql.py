import pymysql


# # 创建数据库连接
# connection = pymysql.connect(
#     host='60.204.186.79',
#     port=10426,
#     user='genshin_tool',
#     password='S8RemGn3PBDE2emz',
#     database='genshin_tool'
# )


# 要插入的数据：data_to_insert_dict
def character_attr_insert_or_update(data_to_insert_dict):
    global connection, cursor
    try:
        # 创建数据库连接
        connection = pymysql.connect(
            host='60.204.186.79',
            port=10426,
            user='genshin_tool',
            password='S8RemGn3PBDE2emz',
            database='genshin_tool'
        )

        # 创建一个游标对象
        cursor = connection.cursor()

        # 编写 SQL 插入语句
        columns = ','.join([f'{key}' for key, value in data_to_insert_dict.items()])
        # print(columns)
        column_values = ','.join([f'"{value}"' if not isinstance(value, float) else f'{value}' for key, value in data_to_insert_dict.items()])
        # print(column_values)
        column_update_values = ', '.join([f"{key} = '{value}'" if not isinstance(value, float) else f"{key} = {value}" for key, value in data_to_insert_dict.items()])
        # print(column_update_values)
        # INSERT INTO your_table (id, column1, column2)
        # VALUES (1, 'value1', 'value2')
        # ON DUPLICATE KEY UPDATE column1 = 'value1', column2 = 'value2';
        insert_query = "INSERT INTO character_attr (" + columns + ") VALUES (" + column_values + ")"
        var = " ON DUPLICATE KEY UPDATE " + column_update_values
        insert_query += var
        print(insert_query)
        # 执行 SQL 插入操作
        result = cursor.execute(insert_query)
        print('结果影响行数：' + str(result))

        # 提交更改
        connection.commit()

        print(data_to_insert_dict['name'] + " Data inserted or updated successfully!")

    except Exception as e:
        print(f"Error: {e}")
        connection.rollback()

    finally:
        # 关闭游标和连接
        cursor.close()
        connection.close()


# data_to_insert_dict = {'region': '未知', 'weapon_type': '单手剑', 'element_type': '风、岩、雷、水', 'star_level': '五星',
#                        'health_points': 12071, 'attack': 25555, 'defence': 708, 'name': '菲米尼',
#                        'special_dish': '潜怀遐梦', 'break_attr': '攻击力:24.0%'}
# # data_to_insert_dict = {'name': '菲米尼'} # result = 0
# character_attr_insert_or_update(data_to_insert_dict)
