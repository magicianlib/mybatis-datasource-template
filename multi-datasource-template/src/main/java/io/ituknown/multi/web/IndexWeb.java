package io.ituknown.multi.web;

import io.ituknown.multi.src1.domain.Src1User;
import io.ituknown.multi.src1.mapper.Src1UserMapper;
import io.ituknown.multi.src2.domain.Src2User;
import io.ituknown.multi.src2.mapper.Src2UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class IndexWeb {

    @Resource
    private Src1UserMapper src1UserMapper;

    @Resource
    private Src2UserMapper src2UserMapper;

    @GetMapping("/src1")
    public List<Src1User> masterList() {
        return src1UserMapper.findList();
    }

    @GetMapping("/src2")
    public List<Src2User> slaveList() {
        return src2UserMapper.findList();
    }
}
