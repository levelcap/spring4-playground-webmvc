package com.levelcap.spring.playground.webmvc.controller;

import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the /device endpoint which performs basic device detection.
 * Using @RestController, new to Spring 4, that removes the need for @ResponseBody
 * on @RequestMapping methods.
 * 
 * @author Dave Cohen
 * 
 */
@RestController
public class DeviceDetectionController
{

    /**
     * detectDevice takes a Device parameter and checks it for standard device
     * types (normal, mobile, tablet).
     * 
     * @param device
     *            WebMvcConfig adds the interceptors and argument resolvers
     *            required to handle the Device argument
     * @return String message containing the device type.
     */
    // and to populate it with the correct data.
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