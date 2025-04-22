// ==UserScript==
// @name         QQ空间自动点赞 & 滚动
// @namespace    http://tampermonkey.net/
// @version      1.0
// @description  在QQ空间添加一个按钮，点击后自动点赞并滚动
// @author       yefeng
// @match        https://user.qzone.qq.com/*
// @grant        none
// ==/UserScript==

(function () {
    'use strict';

    var x = 5, y = 10; // 滚动增量
    var isRunning = false; // 标记是否正在执行点赞

    // 创建一个按钮
    function createButton() {
        var btn = document.createElement('button');
        btn.innerText = '开始自动点赞';
        btn.style.position = 'fixed';
        btn.style.top = '50px';
        btn.style.right = '20px';
        btn.style.zIndex = '9999';
        btn.style.padding = '10px';
        btn.style.backgroundColor = '#ff5722';
        btn.style.color = 'white';
        btn.style.border = 'none';
        btn.style.cursor = 'pointer';
        btn.style.borderRadius = '5px';
        btn.style.fontSize = '16px';

        btn.onclick = function () {
            isRunning = !isRunning;
            btn.innerText = isRunning ? '停止自动点赞' : '开始自动点赞';
            if (isRunning) {
                startAutoClick();
            }
        };

        document.body.appendChild(btn);
    }

    // 自动点赞函数
    function autoClick() {
        if (!isRunning) return;

        var zan = document.getElementsByClassName('item qz_like_btn_v3'); // 获取点赞按钮
        for (var i = 0; i < zan.length; i++) {
            if (zan[i].attributes[6] && zan[i].attributes[6].value === 'like') {
                zan[i].firstChild.click();
            }
        }

        window.scrollBy(x, y);
    }

    // 启动自动点赞
    function startAutoClick() {
        setInterval(autoClick, 2000);
    }

    // 监听动态内容加载，确保点赞按钮始终可以获取
    function observeChanges() {
        var observer = new MutationObserver(function () {
            if (isRunning) {
                autoClick();
            }
        });

        observer.observe(document.body, {childList: true, subtree: true});
    }

    // 初始化
    function init() {
        createButton(); // 创建控制按钮
        observeChanges(); // 监听页面变化
    }

    // 等待 QQ 空间加载完毕后运行脚本
    window.onload = function () {
        setTimeout(init, 3000);
    };
})();
