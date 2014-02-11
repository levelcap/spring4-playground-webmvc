package com.levelcap.spring.playground.webmvc.controller;

import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Using @RestController, new to Spring 4, that removes the need for @ResponseBody on methods
@RestController
public class DeviceDetectionController
{

    @RequestMapping("/device")
    public String detectDevice(Device device)
    {
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        }

        return "You are accessing this page via a " + deviceType + " browser.";
    }

}