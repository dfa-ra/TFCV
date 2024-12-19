package org.example.complex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Complex {
    private double x;
    private double y;

    public Complex sum(Complex b) {
        return new Complex(this.x + b.x, this.y + b.y);
    }

    public Complex sub(Complex b) {
        return sum(b.neg());
    }

    public Complex mul(Complex b) {
        return new Complex(this.x * b.x - this.y * b.y, this.x * b.y + this.y * b.x);
    }

    public Complex pow(int n) {
        Complex res = new Complex(this.x, this.y);
        for (int i = 1; i < n; ++i) {
            res = res.mul(this);
        }
        return res;
    }

    public Complex div(Complex b) {
        double n = b.x * b.x + b.y * b.y;
        Complex mulled = this.mul(b.conjugate());
        return new Complex(mulled.x / n, mulled.y / n);
    }

    public double mod() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Complex conjugate() {
        return new Complex(this.x, -this.y);
    }

    public Complex neg() {
        return new Complex(-this.x, -this.y);
    }

    public static Complex valueOf(int x) {
        return new Complex(x, 0);
    }
}
