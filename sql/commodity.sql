show databases;
use stevendb;


CREATE TABLE `commodity`
(
    `comId`       int(11) NOT NULL auto_increment,
    `cname`       varchar(100) CHARACTER SET utf8 DEFAULT NULL,
    `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
    `price`       varchar(10) CHARACTER SET utf8  DEFAULT NULL,
    `pic`         varchar(200) CHARACTER SET utf8 DEFAULT NULL,
    PRIMARY KEY (`comId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

insert into commodity (cname, description, price, pic)
values ('德钰按摩枪', '德钰按摩枪筋膜枪按摩枪肌肉放松器按摩器筋膜球棒健身锤静音电动冲击枪', '658', 'pic/commodity1.jpg');
insert into commodity (cname, description, price, pic)
values ('多德士仰卧板', '多德士仰卧板家用仰卧起坐健身器材多功能辅助腹肌训练器收腹机腹肌板健身板', '168', 'pic/commodity2.jpg');
insert into commodity (cname, description, price, pic)
values ('翔威脚蹬拉力器', '翔威脚蹬拉力器仰卧起坐弹力带家用扩胸臂力器健腹瘦肚子拉力带力量训练拉力绳', '69', 'pic/commodity3.jpg');
insert into commodity (cname, description, price, pic)
values ('ADKING收腹机', 'ADKING收腹机美腰机仰卧起坐健身器材 男女家用腹肌锻炼卷腹翘臀运动AJ36603', '269', 'pic/commodity4.jpg');
insert into commodity (cname, description, price, pic)
values ('Keep 智能动感单车', 'Keep 智能动感单车C1 家用健身车 运动减脂器材室内脚踏车 智联App', '2899', 'pic/commodity5.jpg');
insert into commodity (cname, description, price, pic)
values ('sunlee仰卧起坐辅助器', 'sunlee仰卧起坐辅助器健身器材吸盘式仰卧起坐板家用多功能健腹收腹', '3935', 'pic/commodity6.jpg');
insert into commodity (cname, description, price, pic)
values ('德国HOTKNEE健身仪', '德国HOTKNEE智能黑科技健身仪懒人健腹肌肉贴收腹机家用减肚子腰腹训练神器', '139', 'pic/commodity7.jpg');
insert into commodity (cname, description, price, pic)
values ('ANBU甩脂机', 'ANBU甩脂机抖抖机家用减肥器材懒人塑身瘦身瘦腿健身器材AB-808 ', '378', 'pic/commodity8.jpg');
insert into commodity (cname, description, price, pic)
values ('仰卧板', '多功能仰卧起坐健身器材家用仰卧板收腹机腹肌健身器辅助器卷腹机 【年货节领券', '398', 'pic/commodity9.jpg');
insert into commodity (cname, description, price, pic)
values ('飞尔顿腕力球', '飞尔顿腕力球臂力器 握力器 手腕臂力训练离心陀螺球 自启动铂金彩光', '55', 'pic/commodity10.jpg');
insert into commodity (cname, description, price, pic)
values ('杜威克墙体双杆', '杜威克双杆单杠引体向上体育运动健身器材家用品门框门上单杠室内墙体双杆 红黑款', '99', 'pic/commodity11.jpg');
insert into commodity (cname, description, price, pic)
values ('李宁跑步负重沙袋', '李宁跑步负重沙袋隐形绑腿绑手腕健身训练负重沙袋 铁砂装（2只装共', '39', 'pic/commodity12.jpg');
insert into commodity (cname, description, price, pic)
values ('艾美仕腹肌轮', '艾美仕腹肌轮健身器材家用男收腹机瘦肚子运动滚轮腹部', '3935', 'pic/commodity13.jpg');
insert into commodity (cname, description, price, pic)
values ('汗马家用动感单车', '汗马家用动感单车豪华超静音运动健身车减肥健身器材 运动款+防滑脚踏+精钢飞', '499', 'pic/commodity14.jpg');
insert into commodity (cname, description, price, pic)
values ('李宁俯卧撑支架', '李宁俯卧撑支架S型防滑钢制俯卧撑支架 室内家用胸肌锻炼健身器材', '49', 'pic/commodity15.jpg');
insert into commodity (cname, description, price, pic)
values ('诚悦电镀哑铃', '诚悦电镀哑铃杠铃30kg(15kg*2)男女士运动健身训练器材家', '329', 'pic/commodity16.jpg');
insert into commodity (cname, description, price, pic)
values ('李宁脚蹬拉力器', '李宁脚蹬拉力器仰卧起坐瘦肚子卷腹家用健身瑜伽女瘦腰翘臀减肥神器拉力绳', '71', 'pic/commodity17.jpg');
insert into commodity (cname, description, price, pic)
values ('CALLIVEN拉力绳', 'CALLIVEN拉力绳弹力绳弹力带男拉力带阻力带拉力器扩胸器家用健身器材 乳胶拉', '135', 'pic/commodity18.jpg');
insert into commodity (cname, description, price, pic)
values ('硬派健身美食', '100卡美食 超低卡美食吃出好身材！ 新年新书到,自营图书每满100减', '48', 'pic/commodity19.jpg');
insert into commodity (cname, description, price, pic)
values ('汗马家用动感单车', '汗马家用动感单车静音运动减肥器材健身车室内脚踏车 智能游戏APP+双面保护罩', '699', 'pic/commodity20.jpg');
insert into commodity (cname, description, price, pic)
values ('杜威克仰卧起坐板', '仰卧起坐健身器材辅助器吸盘式仰卧起坐板家用多功能健腹收腹机运动减肥', '35', 'pic/commodity21.jpg');
insert into commodity (cname, description, price, pic)
values ('华为跑步机', 'DFH运动健康生态款 佑美U3H跑步机家用静音可折叠免安装62cm宽大跑台', '1999', 'pic/commodity22.jpg');
insert into commodity (cname, description, price, pic)
values ('能耐多功能训练套装', '臂力器40公斤训练套装 u型臂力器健身器材装备家用男士臂', '7975', 'pic/commodity23.jpg');


-- commit;

