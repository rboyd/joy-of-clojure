(defn f-values [f max-x max-y]
  (for [x (range max-x) y (range max-y)] [x y (rem (f x y) 256) ]))

(def frame  (java.awt.Frame.))

(.setVisible frame true)

(def gfx (.getGraphics frame))

(defn clear [g] (.clearRect g 0 0 200 200))

(defn draw-values [f xs ys]
  (clear gfx)
  (.setSize frame  (java.awt.Dimension. xs ys))
  (doseq [[x y v] (f-values f xs ys)]
    (.setColor gfx (java.awt.Color. v v v))
    (.fillRect gfx x y 1 1)))
