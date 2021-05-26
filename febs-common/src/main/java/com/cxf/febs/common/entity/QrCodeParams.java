package com.cxf.febs.common.entity;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.Builder;
import lombok.Data;

/**
 * @author sixpence
 * @version 1.0 2021/5/26
 */
@Data
@Builder
public class QrCodeParams {
    /**
     * 二维码内容
     */
    private String txt;
    /**
     * 二维码网络路径
     */
    private String qrCodeUrl;

    /**
     * 二维码生成物理路径
     */
    private String filePath;
    /**
     * 二维码生成图片名称（包含后缀名）
     */
    private String fileName;
    /**
     * logo图片
     */
    private String logoPath;
    /**
     * 二维码宽度
     */
    private Integer width = 300;
    /**
     * 二维码高度
     */
    private Integer height = 300;
    /**
     * 前景色
     */
    private Integer onColor = 0xFF000000;
    /**
     * 背景色
     */
    private Integer offColor = 0xFFFFFFFF;
    /**
     * 白边大小，取值范围0~4
     */
    @Builder.Default
    private Integer margin = 1;
    /**
     * 二维码容错率
     */
    private ErrorCorrectionLevel level = ErrorCorrectionLevel.L;

    /**
     * 返回文件后缀名
     * @return
     */
    public String getSuffixName(){
        String imgName = this.getFileName();
        if(imgName != null && !"".equals(imgName)){
            String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
            return suffix;
        }
        return "";
    }

}
