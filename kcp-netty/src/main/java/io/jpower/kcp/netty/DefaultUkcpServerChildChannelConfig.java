package io.jpower.kcp.netty;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;

import java.util.Map;
import java.util.Objects;

import static io.jpower.kcp.netty.UkcpChannelOption.*;

/**
 * @author <a href="mailto:szhnet@gmail.com">szh</a>
 */
public class DefaultUkcpServerChildChannelConfig extends DefaultChannelConfig implements UkcpChannelConfig {

    private final Ukcp ukcp;

    public DefaultUkcpServerChildChannelConfig(UkcpServerChildChannel channel, Ukcp ukcp) {
        super(channel, new FixedRecvByteBufAllocator(Consts.FIXED_RECV_BYTEBUF_ALLOCATOR_SIZE));
        this.ukcp = Objects.requireNonNull(ukcp, "ukcp");
    }

    @Override
    @SuppressWarnings("deprecation")
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(
                super.getOptions(),
                UKCP_NODELAY, UKCP_INTERVAL, UKCP_FAST_RESEND, UKCP_NOCWND, UKCP_MTU, UKCP_RCV_WND, UKCP_SND_WND,
                UKCP_STREAM, UKCP_AUTO_SET_CONV, UKCP_FAST_FLUSH);
    }

    @Override
    @SuppressWarnings({"unchecked", "deprecation"})
    public <T> T getOption(ChannelOption<T> option) {
        if (option == UKCP_NODELAY) {
            return (T) Boolean.valueOf(isNodelay());
        }
        if (option == UKCP_INTERVAL) {
            return (T) Integer.valueOf(getInterval());
        }
        if (option == UKCP_FAST_RESEND) {
            return (T) Integer.valueOf(getFastResend());
        }
        if (option == UKCP_NOCWND) {
            return (T) Boolean.valueOf(isNocwnd());
        }
        if (option == UKCP_MTU) {
            return (T) Integer.valueOf(getMtu());
        }
        if (option == UKCP_RCV_WND) {
            return (T) Integer.valueOf(getRcvWnd());
        }
        if (option == UKCP_SND_WND) {
            return (T) Integer.valueOf(getSndWnd());
        }
        if (option == UKCP_STREAM) {
            return (T) Boolean.valueOf(isStream());
        }
        if (option == UKCP_AUTO_SET_CONV) {
            return (T) Boolean.valueOf(isAutoSetConv());
        }
        if (option == UKCP_FAST_FLUSH) {
            return (T) Boolean.valueOf(isFastFlush());
        }
        return super.getOption(option);
    }

    @Override
    @SuppressWarnings("deprecation")
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);

        if (option == UKCP_NODELAY) {
            setNodelay((Boolean) value);
        } else if (option == UKCP_INTERVAL) {
            setInterval((Integer) value);
        } else if (option == UKCP_FAST_RESEND) {
            setFastResend((Integer) value);
        } else if (option == UKCP_NOCWND) {
            setNocwnd((Boolean) value);
        } else if (option == UKCP_MTU) {
            setMtu((Integer) value);
        } else if (option == UKCP_RCV_WND) {
            setRcvWnd((Integer) value);
        } else if (option == UKCP_SND_WND) {
            setSndWnd((Integer) value);
        } else if (option == UKCP_STREAM) {
            setStream((Boolean) value);
        } else if (option == UKCP_AUTO_SET_CONV) {
            setAutoSetConv((Boolean) value);
        } else if (option == UKCP_FAST_FLUSH) {
            setFastFlush((Boolean) value);
        } else {
            return super.setOption(option, value);
        }

        return true;
    }

    @Override
    public boolean isNodelay() {
        return ukcp.isNodelay();
    }

    @Override
    public UkcpChannelConfig setNodelay(boolean nodelay) {
        ukcp.setNodelay(nodelay);
        return this;
    }

    @Override
    public int getInterval() {
        return ukcp.getInterval();
    }

    @Override
    public UkcpChannelConfig setInterval(int interval) {
        ukcp.setInterval(interval);
        return this;
    }

    @Override
    public int getFastResend() {
        return ukcp.getFastResend();
    }

    @Override
    public UkcpChannelConfig setFastResend(int fastResend) {
        ukcp.setFastResend(fastResend);
        return this;
    }

    @Override
    public boolean isNocwnd() {
        return ukcp.isNocwnd();
    }

    @Override
    public UkcpChannelConfig setNocwnd(boolean nocwnd) {
        ukcp.setNocwnd(nocwnd);
        return this;
    }

    @Override
    public int getMtu() {
        return ukcp.getMtu();
    }

    @Override
    public UkcpChannelConfig setMtu(int mtu) {
        ukcp.setMtu(mtu);
        return this;
    }

    @Override
    public int getRcvWnd() {
        return ukcp.getRcvWnd();
    }

    @Override
    public UkcpChannelConfig setRcvWnd(int rcvWnd) {
        ukcp.setRcvWnd(rcvWnd);
        return this;
    }

    @Override
    public int getSndWnd() {
        return ukcp.getSndWnd();
    }

    @Override
    public UkcpChannelConfig setSndWnd(int sndWnd) {
        ukcp.setSndWnd(sndWnd);
        return this;
    }

    @Override
    public boolean isStream() {
        return ukcp.isStream();
    }

    @Override
    public UkcpChannelConfig setStream(boolean stream) {
        ukcp.setStream(stream);
        return this;
    }

    @Override
    public boolean isAutoSetConv() {
        return ukcp.isAutoSetConv();
    }

    @Override
    public UkcpChannelConfig setAutoSetConv(boolean autoSetConv) {
        ukcp.setAutoSetConv(autoSetConv);
        return this;
    }

    @Override
    public boolean isFastFlush() {
        return ukcp.isFastFlush();
    }

    @Override
    public UkcpChannelConfig setFastFlush(boolean fastFlush) {
        ukcp.setFastFlush(fastFlush);
        return this;
    }

    @Override
    public UkcpChannelConfig setAllocator(ByteBufAllocator allocator) {
        super.setAllocator(allocator);
        ukcp.setByteBufAllocator(allocator);
        return this;
    }

    @Override
    public UkcpChannelConfig setWriteSpinCount(int writeSpinCount) {
        super.setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override
    public UkcpChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        super.setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override
    @Deprecated
    public UkcpChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        super.setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override
    public UkcpChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        super.setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override
    public UkcpChannelConfig setAutoRead(boolean autoRead) {
        super.setAutoRead(autoRead);
        return this;
    }

    @Override
    public UkcpChannelConfig setAutoClose(boolean autoClose) {
        super.setAutoClose(autoClose);
        return this;
    }

    @Override
    public UkcpChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        super.setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override
    public UkcpChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        super.setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override
    public UkcpChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override
    public UkcpChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        super.setMessageSizeEstimator(estimator);
        return this;
    }

}
