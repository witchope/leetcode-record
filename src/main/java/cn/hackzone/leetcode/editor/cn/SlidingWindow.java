package cn.hackzone.leetcode.editor.cn;

import java.util.*;

public class SlidingWindow {

    private final int windowSize; // 窗口大小
    private int lastAck = 0; // 最后确认的数据包编号
    private int lastSent = 0; // 最后发送的数据包编号
    private final Map<Integer, Boolean> sentPackets = new HashMap<>(); // 已发送的数据包
    private final Map<Integer, Boolean> receivedPackets = new HashMap<>(); // 已接收的数据包

    public SlidingWindow(int windowSize) {
        this.windowSize = windowSize;
    }

    // 发送数据包
    public void sendPacket(int packetNumber) {
        sentPackets.put(packetNumber, false);
        lastSent = packetNumber;
    }

    // 接收数据包
    public void receivePacket(int packetNumber) {
        receivedPackets.put(packetNumber, true);
        if (packetNumber > lastAck) {
            lastAck = packetNumber;
        }
    }

    // 获取下一个可发送的数据包
    public int getNextPacket() {
        int nextPacket = lastAck + 1;
        while (nextPacket <= lastSent && nextPacket < lastAck + windowSize) {
            if (!sentPackets.get(nextPacket)) {
                return nextPacket;
            }
            nextPacket++;
        }
        return -1;
    }

    // 检查是否可以关闭连接
    public boolean canClose() {
        return lastAck == lastSent && receivedPackets.get(lastAck);
    }

    // 测试代码
    public static void main(String[] args) {
        SlidingWindow sw = new SlidingWindow(3);
        sw.sendPacket(1);
        sw.sendPacket(2);
        sw.sendPacket(3);
        sw.sendPacket(4);
        sw.sendPacket(5);
        sw.receivePacket(1);
        sw.receivePacket(2);
        sw.receivePacket(3);
        sw.receivePacket(5);
        int nextPacket = sw.getNextPacket();
        while (nextPacket != -1) {
            System.out.println("Sending packet " + nextPacket);
            sw.sendPacket(nextPacket);
            nextPacket = sw.getNextPacket();
        }
        if (sw.canClose()) {
            System.out.println("Connection closed.");
        }
    }

}
