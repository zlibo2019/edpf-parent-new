package com.weds.edwx.service;

import com.weds.edwx.entity.DineOrderPrintEntity;
import com.weds.edwx.entity.EdDineFoodEntity;
import com.weds.edwx.entity.EdDineOrderDetailEntity;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class DineOrderPrint implements Printable {
    private DineOrderPrintEntity dineOrderPrintEntity;
    private int width;

    public DineOrderPrint(DineOrderPrintEntity dineOrderPrintEntity, int width) {
        this.dineOrderPrintEntity = dineOrderPrintEntity;
        this.width = width;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        printOrder((Graphics2D) graphics, pageFormat, this.width);
        switch (pageIndex) {
            case 0:
                return PAGE_EXISTS;
            default:
                return NO_SUCH_PAGE;
        }
    }

    private void printOrder(Graphics2D g2, PageFormat pageFormat, int width) {
        int lineHeight = 5;   //第一行与第二行的距离
        int lineNum = 1;
        g2.setColor(Color.BLACK);
        // 打印起点坐标
        double x = pageFormat.getImageableX();
        double y = pageFormat.getImageableY();
        // 设置打印字体
        Font font = new Font("宋体", Font.BOLD, 10);
        g2.setFont(font);// 设置字体
        float heigth = font.getSize2D();// 字体高度

        // 订单标题
        drawCenterString(g2, dineOrderPrintEntity.getTitle(), font, width, (float) y + heigth + lineHeight);

        // 订单信息
        lineNum++;
        float line = lineNum * (heigth + lineHeight);
        FontMetrics metrics = g2.getFontMetrics(font);
        int paddingRight = metrics.stringWidth("字") * 5;
        g2.drawString("餐别：", (float) x, (float) y + line);
        g2.drawString(dineOrderPrintEntity.getMealName(), (float) x + paddingRight, (float) y + line);
        lineNum++;
        line = lineNum * (heigth + lineHeight);
        g2.drawString("下单时间：", (float) x, (float) y + line);
        g2.drawString(dineOrderPrintEntity.getOrderDate(), (float) x + paddingRight, (float) y + line);
        if (dineOrderPrintEntity.isSendFlag()) {
            lineNum++;
            line = lineNum * (heigth + lineHeight);
            g2.drawString("送餐地点：", (float) x, (float) y + line);
            g2.drawString(dineOrderPrintEntity.getSendAddr(), (float) x + paddingRight, (float) y + line);
            lineNum++;
            line = lineNum * (heigth + lineHeight);
            g2.drawString("送餐时间：", (float) x, (float) y + line);
            g2.drawString(dineOrderPrintEntity.getSendTime(), (float) x + paddingRight, (float) y + line);
            Font flagFont = new Font("宋体", Font.BOLD, 20);
            FontMetrics fontMetrics = g2.getFontMetrics(flagFont);
            int flagWidth = fontMetrics.stringWidth("字");
            g2.setFont(flagFont);
            g2.drawString("外送", (float) width - flagWidth * 3, (float) y + line);
            g2.setFont(font);
        }
        lineNum++;
        line = lineNum * (heigth + lineHeight);
        drawSplitLine(g2, font, width, (float) x, (float) y + line);

        // 菜品信息
        lineNum++;
        line = lineNum * (heigth + lineHeight);
        g2.drawString("菜品", (float) x, (float) y + line);
        g2.drawString("单价", (float) (x + 0.3 * width), (float) y + line);
        g2.drawString("数量", (float) (x + 0.52 * width), (float) y + line);
        g2.drawString("小计", (float) (x + 0.65 * width), (float) y + line);

        List<EdDineOrderDetailEntity> foodList = dineOrderPrintEntity.getList();
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        for (EdDineOrderDetailEntity entity : foodList) {
            lineNum++;
            line = lineNum * (heigth + lineHeight);
            g2.drawString(entity.getFoodName(), (float) x, (float) y + line);
            g2.drawString(entity.getFoodPrice().setScale(2, BigDecimal.ROUND_HALF_UP) + "元", (float) (x + 0.3 * width), (float) y + line);
            g2.drawString(entity.getFoodNum() + "份", (float) (x + 0.52 * width), (float) y + line);
            float sub = entity.getFoodPrice().floatValue() * entity.getFoodNum();
            g2.drawString(decimalFormat.format(sub) + "元", (float) (x + 0.65 * width), (float) y + line);
        }

        lineNum++;
        line = lineNum * (heigth + lineHeight);
        drawSplitLine(g2, font, width, (float) x, (float) y + line);

        lineNum++;
        line = lineNum * (heigth + lineHeight);
        g2.drawString("合计：", (float) (x + 0.5 * width), (float) y + line);
        g2.drawString(decimalFormat.format(Double.parseDouble(dineOrderPrintEntity.getOrderPrice())) + "元", (float) (x + 0.65 * width), (float) y + line);
    }

    private static void drawCenterString(Graphics2D g2, String text, Font font, int width, float y) {
        FontMetrics metrics = g2.getFontMetrics(font);
        float x = (float) (width - metrics.stringWidth(text)) / 2;
        // int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.setFont(font);
        g2.drawString(text, x, y);
    }

    private static void drawSplitLine(Graphics2D g2, Font font, int width, float x, float y) {
        FontMetrics metrics = g2.getFontMetrics(font);
        int num = width / metrics.stringWidth("-");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append("-");
        }
        g2.drawString(sb.toString(), x, y);
    }
}
