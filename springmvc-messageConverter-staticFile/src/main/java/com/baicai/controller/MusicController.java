package com.baicai.controller;

import com.baicai.pojo.Music;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

@Controller
@RequestMapping(value = "/music")
public class MusicController {

    @RequestMapping("/music")
    public String music() {
        return "music";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping("/sendXml")
    public void sendXml(@RequestBody Music music) {
        System.out.println(music);
    }

    @RequestMapping("/readMusic")
    public String readMusic() {
        return "readMusic";
    }

    @RequestMapping(value = "/readXml", method = RequestMethod.GET)
    public @ResponseBody Music readXml() throws Exception {
        // 获取JAXBContext实例
        JAXBContext ctx = JAXBContext.newInstance(Music.class);
        // 获取Unmarshaller实例（用于转换）
        Unmarshaller unmar = ctx.createUnmarshaller();
        // 进行转换
        final InputStream is = this.getClass().getClassLoader().getResourceAsStream("music.xml");
        Music music = (Music) unmar.unmarshal(is);
        System.out.println(music);
        return music;
    }

}
