<template>
    <div id="app-container">
        <div class="app-header">
            Genshin Impact Damage Calculator
        </div>
        <div class="app-body">
            <div class="level-zone">
                角色等级、技能等级、命座等级
            </div>
            <div class="equipment-zone">
                角色武器、圣遗物
            </div>
            <div class="attr-zone">
                角色基础属性、进阶属性
            </div>
            <div class="dmg-zone">
                角色普攻、战技、大招伤害（不暴击、期望、暴击）
            </div>
        </div>
        <div class="app-footer">

        </div>

    </div>
</template>

<script>
export default {
    name: "DamageCalculatorView"
}
</script>

<style scoped>
#app-container {
    /* 弹性容器外及弹性子元素内是正常渲染的。弹性盒子只定义了弹性子元素如何在弹性容器内布局。
       弹性子元素通常在弹性盒子内一行显示。默认情况每个容器只有一行。*/
    display: flex;
    /*容器默认存在两根轴线，一根主轴（main axis），一根交叉轴（cross axis），项目默认沿主轴排列。*/
    flex-direction: column; /*默认情况下，元素排布从左至右，从上至下。  column（从上至下） */
    /*必须指定伸缩容器的高度，容器才会有可用空间，flex-grow才会生效*/
    height: 100vh;
}

.app-header {
    /* flex-basis属性定义了项目占据主轴空间（main size）大小。 */
    display: flex;
    flex-basis: 50px;
    border: 2px solid red;
    /*内容垂直水平居中*/
    align-items: center;
    justify-content: center;

}

.app-body {
    flex-basis: 720px;
    background-color: #6dc55f;
    display: flex;
}

.level-zone {
    height: 100%;
    width: 25%;
    background-color: #8888be;
}

.equipment-zone {
    height: 100%;
    width: 25%;
    background-color: red;
}

.attr-zone {
    height: 100%;
    width: 25%;
    background-color: #d5a3d5;
}

.dmg-zone {
    height: 100%;
    width: 25%;
    background-color: orange;
}

.app-footer {
    border: 1px solid lightblue;
    /*flex-basis: 0;*/
    /* flex-grow属性定义项目的放大比例 */
    flex-grow: 1; /* 子元素占据剩余空间 */
}
</style>