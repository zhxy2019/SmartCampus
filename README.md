# SmartCampus
智慧校园

类名用大驼峰 变量用小驼峰
所有jsp放在WEB-INF/views下面
每人分配一个Controller以减少冲突，
ScorePredictController 对应成绩分析功能,包括数据统计图表和标签展示，学生成绩可解释预测
StudyProfileController 对应学业画像展示,包括数据统计图表和标签展示
ConsumptionProfileController 对应消费画像展示,包括数据统计图表和标签展示

学生学业标签如下：
student表中对应学生总体情况信息
学霸标签：grind 0为学霸 1为学习普通 2为学渣
挂科标签：fail 0为无挂科 1为有挂科 2 为有留级风险 3为有退学风险
studentstudy表中对应学生各学期情况信息
成绩变化标签：ascend 学生成绩较上学期变化情况，等于0为上升 等于1不变 等于2下降
学生行为标签如下：
主要在studentbehavior表中
是否有早餐习惯标签 breakfastLabel 1为有早餐习惯 0为没有
三餐是否规律标签 mealLabel 0为三餐规律 1为三餐普通 2 为三餐不规律
消费标签 consumptionLabel 0为消费较低 1为消费普通 2为消费较高 3为消费过高 4为消费过低
晚睡标签 sleeplateLabel 1为晚睡0为不晚睡
所有标签-1标签没有该标签，可能情况为学生数据过少数据缺失或学生未住校。
